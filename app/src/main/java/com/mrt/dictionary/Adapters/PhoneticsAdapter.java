package com.mrt.dictionary.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrt.dictionary.Models.Phonetics;
import com.mrt.dictionary.R;
import com.mrt.dictionary.ViewHolders.PhoneticViewHolder;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) { /*constructor*/
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
        holder.textView_phonetic.setText(phoneticsList.get(position).getText());
        holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /*mediaplayer class'ı için bir örnek oluşturmamız gerekiyor*/
                MediaPlayer player = new MediaPlayer();
                try{
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource("https" + phoneticsList.get(position).getAudio()); /*api adresine gidip oradan alacak*/
                    player.prepare();
                    player.start();

                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(context, "Couldn't play audio.", Toast.LENGTH_SHORT).show(); /*sesi çalamazsa diye*/
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
