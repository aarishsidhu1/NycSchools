package us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.R;
import us.aarishsidhu.a20230208_aarishpreetsinghsidhu_nycschools.network.model.School;

import java.util.List;

public class NycSchoolAdapter extends RecyclerView.Adapter<NycSchoolAdapter.NycViewHolder>{

    List<School> schools;
    Context context ;
    public NycSchoolAdapter(Context context,List<School> schools){
        this.schools = schools;
        this.context = context;
    }

    @NonNull
    @Override
    public NycViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NycViewHolder(LayoutInflater.from(context).inflate(R.layout.nyc_school_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull NycViewHolder holder, int position) {
        holder.tvName.setText(schools.get(position).schoolName);
        holder.tvName.setOnClickListener(view -> {
            Intent intent = new Intent(context,DetailsActivity.class);
            intent.putExtra("DBN",schools.get(position).dbn);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class  NycViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;

        public NycViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
