package com.example.roommate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roommate.databinding.ActivityMatchingStartBinding;
import com.example.roommate.databinding.DialogMatchingBinding;
import com.example.roommate.databinding.ItemMatchingBinding;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class matching_start extends AppCompatActivity {
    private ActivityMatchingStartBinding binding;


    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private UserAccount myProfile;
    private final MutableLiveData<List<UserAccount>> profiles = new MutableLiveData<>();
    private final MatchingAdapter adapter = new MatchingAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMatchingStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onInit();
        fetchItems();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void onInit() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        binding.userContainer.setOnClickListener(v -> {
            if (v.getTag() instanceof UserAccount) {
                showProfileDetailsDialog((UserAccount) v.getTag());
            }
        });

        adapter.setOnItemClickListener(this::showProfileDetailsDialog);
        binding.recyclerView.setAdapter(adapter);

        profiles.observe(this, profiles -> {
            String uid = auth.getUid();
            assert (uid != null);

            // 내 프로필 찾기
            for (UserAccount profile : profiles) {
                if (TextUtils.equals(profile.getIdToken(), uid)) {
                    profiles.remove(profile);
                    myProfile = profile;
                    break;
                }
            }

            // 내 프로필 못찾으면 액티비티 종료
            if (myProfile == null) {
                finish();
                return;
            }

            ArrayList<UserAccount> clone = new ArrayList<>(profiles);
            Collections.shuffle(clone);
            for (UserAccount profile : clone) {
                if (TextUtils.equals(profile.getSmoke(), myProfile.getSmoke()) &&
                        TextUtils.equals(profile.getExercise(), myProfile.getExercise()) &&
                        TextUtils.equals(profile.getClean(), myProfile.getClean()) &&
                        TextUtils.equals(profile.getEatIn(), myProfile.getEatIn()) &&
                        TextUtils.equals(profile.getSleepHap(), myProfile.getSleepHap()) &&
                        TextUtils.equals(profile.getGame(), myProfile.getGame()) &&
                        TextUtils.equals(profile.getAlcohol(), myProfile.getAlcohol()) &&
                        TextUtils.equals(profile.getDorm(), myProfile.getDorm()) &&
                        TextUtils.equals(profile.getGen(), myProfile.getGen())) {
                    binding.userContainer.setTag(profile);
                    binding.userNameTextView.setText(profile.getName());
                    break;
                }
            }

            if (TextUtils.isEmpty(binding.userNameTextView.getText().toString().trim())) {
                binding.userNameTextView.setText("Not found");
            }

            ArrayList<UserAccount> filteredProfile = new ArrayList<>();
            for (UserAccount profile : profiles) {
                if (TextUtils.equals(profile.getDorm(), myProfile.getDorm()) &&
                        TextUtils.equals(profile.getGen(), myProfile.getGen())) {
                    filteredProfile.add(profile);
                }
            }

            adapter.setItems(filteredProfile);
            binding.progressIndicator.setVisibility(View.GONE);
        });
    }

    private void fetchItems() {
        new Thread() {
            private final FirebaseDatabase db = FirebaseDatabase.getInstance();

            @Override
            public void run() {
                try {
                    DataSnapshot snapshot = Tasks.await(db.getReference()
                            .child("Roommate")
                            .child("UserAccount")
                            .get());
                    ArrayList<UserAccount> profiles = new ArrayList<>();

                    for (DataSnapshot child : snapshot.getChildren()) {
                        profiles.add(child.getValue(UserAccount.class));
                    }

                    matching_start.this.profiles.postValue(profiles);

                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void showProfileDetailsDialog(UserAccount profile) {
        DialogMatchingBinding dialogBinding = DialogMatchingBinding.inflate(getLayoutInflater());
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogBinding.getRoot())
                .create();

        dialogBinding.userNameTextView.setText(profile.getName());

        StringBuilder content = new StringBuilder();
        content.append("흡연 : ").append(profile.getSmoke()).append("\n");
        content.append("운동 : ").append(profile.getExercise()).append("\n");
        content.append("청소 : ").append(profile.getClean()).append("\n");
        content.append("실내취식 : ").append(profile.getEatIn()).append("\n");
        content.append("잠버릇 : ").append(profile.getSleepHap()).append("\n");
        content.append("게임 : ").append(profile.getGame()).append("\n");
        content.append("음주 : ").append(profile.getAlcohol());

        if (!profile.getWakeup().isEmpty()) {
            content.append("기상시간 : ").append(profile.getWakeup()).append("\n");
        }

        if (!profile.getSleep().isEmpty()) {
            content.append("취침시간 : ").append(profile.getSleep()).append("\n");
        }

        if (!profile.getFloor().isEmpty()) {
            content.append("선호층수 : ").append(profile.getFloor()).append("\n");
        }

        if (!profile.getExam().isEmpty()) {
            content.append("반수/편입 : ").append(profile.getExam()).append("\n");
        }

        if (!profile.getShower().isEmpty()) {
            content.append("샤워시간 : ").append(profile.getShower()).append("\n");
        }

        if (!profile.getHome().isEmpty()) {
            content.append("본가 방문 주기 : ").append(profile.getHome()).append("\n");
        }

        if (!profile.getAlcPeriod().isEmpty()) {
            content.append("음주 빈도 : ").append(profile.getAlcPeriod()).append("\n");
        }

        if (!profile.getWhenShower().isEmpty()) {
            content.append("샤워 시간대 : ").append(profile.getWhenShower()).append("\n");
        }

        if (!profile.getStudy().isEmpty()) {
            content.append("공부장소 : ").append(profile.getStudy()).append("\n");
        }

        if (!profile.getWarm().isEmpty()) {
            content.append("더위 : ").append(profile.getWarm()).append("\n");
        }

        if (!profile.getCold().isEmpty()) {
            content.append("추위 : ").append(profile.getCold()).append("\n");
        }

        if (!profile.getDorm().isEmpty()) {
            content.append("기숙사 : ").append(profile.getDorm()).append("\n");
        }

        content.deleteCharAt(content.length() - 1);

        dialogBinding.contentTextView.setText(content.toString());

        // 신청 버튼 선택시
        dialogBinding.positiveButton.setOnClickListener(v -> {
            dialog.dismiss();
        });

        // 거절 버튼 선택시
        dialogBinding.negativeButton.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }

    private static class MatchingAdapter extends RecyclerView.Adapter<MatchingAdapter.ItemViewHolder> {
        private final List<UserAccount> profiles = new ArrayList<UserAccount>();
        private Consumer<UserAccount> onItemClickListener;

        public void setItems(List<UserAccount> profiles) {
            this.profiles.clear();
            this.profiles.addAll(profiles);
            notifyDataSetChanged();
        }

        public void setOnItemClickListener(Consumer<UserAccount> onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemMatchingBinding binding = ItemMatchingBinding.inflate(inflater, parent, false);
            return new ItemViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            UserAccount profile = profiles.get(position);

            holder.binding.getRoot().setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    onItemClickListener.accept(profile);
                }
            });

            holder.binding.userNameTextView.setText(profile.getName());
        }

        @Override
        public int getItemCount() {
            return profiles.size();
        }

        static class ItemViewHolder extends RecyclerView.ViewHolder {
            final ItemMatchingBinding binding;

            public ItemViewHolder(ItemMatchingBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }
}