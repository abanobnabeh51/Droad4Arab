package com.drakwola.droad4arab.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakwola.droad4arab.R;
import com.drakwola.droad4arab.ThereProfileActivity;
import com.drakwola.droad4arab.models.ModelPost;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class AdapterPosts extends  RecyclerView.Adapter<AdapterPosts.MyHolder>{
    Context context;
    List<ModelPost> postList;

    public AdapterPosts(Context context, List<ModelPost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_posts, parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String uid =postList.get(position).getpUid();
        String uEmail =postList.get(position).getuEmail();
        String uName =postList.get(position).getuName();
        String uDp =postList.get(position).getuDp();
        String pId =postList.get(position).getpId();
        String pTitle =postList.get(position).getpTitle();
        String pDescription =postList.get(position).getpDescr();
        String pImage =postList.get(position).getpImage();
        String pTimestamp =postList.get(position).getpTime();

        Calendar calendar =Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(pTimestamp));
        String pTime = DateFormat.format("dd/MM/yyyy hh:mm aa", calendar).toString();
        holder.uNameTv.setText(uName);
        holder.pTimeTv.setText(pTime);
        holder.pTitleTv.setText(pTitle);
        holder.pDescriptionTv.setText(pDescription);

        try {
            Picasso.get().load(uDp).placeholder(R.drawable.ic_face_color).into(holder.uPictureIv);
        }catch (Exception e){

        }
        if (pImage.equals("noImage")){
            holder.pImageIv.setVisibility(View.GONE);

        }else{
            try {
                Picasso.get().load(pImage).into(holder.pImageIv);
            }catch (Exception e){

            }
        }

        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "More", Toast.LENGTH_SHORT).show();
            }
        });
        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
            }
        });
        holder.commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Comment", Toast.LENGTH_SHORT).show();
            }
        });
        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show();
            }
        });
        holder.profilelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, ThereProfileActivity.class);
                intent.putExtra("uid",uid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView uPictureIv,pImageIv;
        TextView uNameTv, pTimeTv,pTitleTv ,pDescriptionTv,pLikesTv;
        ImageButton moreBtn;
        Button likeBtn,commentBtn,shareBtn;
        LinearLayout profilelayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);


            uPictureIv =itemView.findViewById(R.id.uPictureIv);
            pImageIv =itemView.findViewById(R.id.pImageIv);
            uNameTv =itemView.findViewById(R.id.uNameTv);
            pTimeTv =itemView.findViewById(R.id.pTimeTv);
            pTitleTv =itemView.findViewById(R.id.pTitleTv);
            pDescriptionTv =itemView.findViewById(R.id.pDescriptionTv);
            pLikesTv =itemView.findViewById(R.id.pLikesTv);
            moreBtn =itemView.findViewById(R.id.moreBtn);
            likeBtn =itemView.findViewById(R.id.likeBtn);
            commentBtn =itemView.findViewById(R.id.commentBtn);
            shareBtn =itemView.findViewById(R.id.shareBtn);
            profilelayout =itemView.findViewById(R.id.profileLayout);

        }
    }
}
