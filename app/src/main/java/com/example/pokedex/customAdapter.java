package com.example.pokedex;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> {
    public String[] pkmn = {"MissingNo","Bulbasaur","Ivysaur","Venusaur","Charmander","Charmeleon","Charizard",
            "Squirtle","Wartortle","Blastoise","Caterpie","Metapod","Butterfree","Weedle","Kakuna","Beedrill",
            "Pidgey","Pidgeotto","Pidgeot","Rattata","Raticate","Spearow","Fearow","Ekans","Arbok","Pikachu",
            "Raichu","Sandshrew","Sandslash","Nidoran","Nidorina","Nidoqueen","Nidoran","Nidorino","Nidoking",
            "Clefairy","Clefable","Vulpix","Ninetales","Jigglypuff","Wigglytuff","Zubat","Golbat","Oddish",
            "Gloom","Vileplume","Paras","Parasect","Venonat","Venomoth","Diglett","Dugtrio","Meowth","Persian",
            "Psyduck","Golduck","Mankey","Primeape","Growlithe","Arcanine","Poliwag","Poliwhirl","Poliwrath","Abra",
            "Kadabra","Alakazam","Machop","Machoke","Machamp","Bellsprout","Weepinbell","Victreebel","Tentacool",
            "Tentacruel","Geodude","Graveler","Golem","Ponyta","Rapidash","Slowpoke","Slowbro","Magnemite","Magneton",
            "Farfetch'd","Doduo","Dodrio","Seel","Dewgong","Grimer","Muk","Shellder","Cloyster","Gastly","Haunter",
            "Gengar","Onix","Drowzee","Hypno","Krabby","Kingler","Voltorb","Electrode","Exeggcute","Exeggutor","Cubone",
            "Marowak","Hitmonlee","Hitmonchan","Lickitung","Koffing","Weezing","Rhyhorn","Rhydon","Chansey","Tangela",
            "Kangaskhan","Horsea","Seadra","Goldeen","Seaking","Staryu","Starmie","Mr. Mime","Scyther","Jynx","Electabuzz",
            "Magmar","Pinsir","Tauros","Magikarp","Gyarados","Lapras","Ditto","Eevee","Vaporeon","Jolteon","Flareon",
            "Porygon","Omanyte","Omastar","Kabuto","Kabutops","Aerodactyl","Snorlax","Articuno","Zapdos","Moltres",
            "Dratini","Dragonair","Dragonite","Mewtwo","Mew"};
    public String[] type = {"Bird/Normal","Grass/Poison","Grass/Poison","Grass/Poison","Fire","Fire","Fire/Flying","Water",
            "Water","Water","Bug","Bug","Bug/Flying","Bug/Poison","Bug/Poison","Bug/Poison","Normal/Flying","Normal/Flying",
            "Normal/Flying","Normal","Normal","Normal/Flying","Normal/Flying","Poison","Poison","Electric","Electric",
            "Ground","Ground","Poison","Poison","Poison/Ground","Poison","Poison","Poison/Ground","Fairy","Fairy","Fire",
            "Fire","Normal/Fairy","Normal/Fairy","Poison/Flying","Poison/Flying","Grass/Poison","Grass/Poison","Grass/Poison",
            "Bug/Grass","Bug/Grass","Bug/Poison","Bug/Poison","Ground","Ground","Normal","Normal","Water","Water","Fighting",
            "Fighting","Fire","Fire","Water","Water","Water/Fighting","Psychic","Psychic","Psychic","Fighting","Fighting",
            "Fighting","Grass/Poison","Grass/Poison","Grass/Poison","Water/Poison","Water/Poison","Rock/Ground","Rock/Ground",
            "Rock/Ground","Fire","Fire","Water/Psychic","Water/Psychic","Electric/Steel","Electric/Steel",
            "Normal/Flying","Normal/Flying","Normal/Flying","Water","Water/Ice","Poison","Poison","Water","Water/Ice",
            "Ghost/Poison","Ghost/Poison","Ghost/Poison","Rock/Ground","Psychic","Psychic","Water","Water","Electric",
            "Electric","Grass/Psychic","Grass/Psychic","Ground","Ground","Fighting","Fighting","Normal","Poison","Poison",
            "Ground/Rock","Ground/Rock","Normal","Grass","Normal","Water","Water","Water","Water","Water","Water/Psychic",
            "Psychic/Fairy","Bug/Flying","Ice/Psychic","Electric","Fire","Bug","Normal","Water","Water/Flying","Water/Ice",
            "Normal","Normal","Water","Electric","Fire","Normal","Rock/Water","Rock/Water","Rock/Water","Rock/Water",
            "Rock/Flying","Normal","Ice/Flying","Electric/Flying","Fire/Flying","Dragon","Dragon","Dragon/Flying",
            "Psychic","Psychic"};
    private String[] localDataSet;
    private Context parentcontext;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private  TextView nameview;
        private TextView typeview;
        private ImageView iconview;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.dexno);//add view here
            nameview = (TextView) view.findViewById(R.id.pkname);
            typeview = (TextView) view.findViewById(R.id.type);
            iconview = (ImageView) view.findViewById(R.id.pkicon);
        }

        public TextView getTextView() {
            return textView;
        }
        public TextView getNameView(){
            return nameview;
        }

        public TextView getTypeview() {
            return typeview;
        }
        public ImageView getIconview(){
            return iconview;
        }
    }

    //step1 : Initialize the dataset of the Adapter.

    public customAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // step 2 : Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);
        parentcontext = viewGroup.getContext();
        return new ViewHolder(view);
    }

    // step 3 : Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if(Integer.parseInt(localDataSet[position])<10) {
            viewHolder.getTextView().setText("00" + localDataSet[position]);
        }
        else if(Integer.parseInt(localDataSet[position])<100) {
            viewHolder.getTextView().setText("0" + localDataSet[position]);
        }
        else{
            viewHolder.getTextView().setText(localDataSet[position]);
        }
        viewHolder.getNameView().setText(pkmn[Integer.parseInt(localDataSet[position])]);
        viewHolder.getTypeview().setText(type[Integer.parseInt(localDataSet[position])]);
        String uri = "@drawable/pic"+localDataSet[position];
        int imageResource = parentcontext.getResources().getIdentifier(uri, null, parentcontext.getPackageName());
        Drawable myDrawable = parentcontext.getResources().getDrawable(imageResource);
        viewHolder.getIconview().setImageDrawable(myDrawable);
    }

    //step 4 : Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}


