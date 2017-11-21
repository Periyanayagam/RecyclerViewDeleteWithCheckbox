package com.mindnotix.recyclerviewcheckboxspinneredittextdelete;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Admin on 08-03-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    MainActivity mainActivity;
    ArrayList<ModelClass> modelClasses;
    ArrayList<String> spinnerDataList;

    public RecyclerViewAdapter(MainActivity mainActivity, ArrayList<ModelClass> modelClasses, ArrayList<String> spinnerDataList) {

        this.mainActivity = mainActivity;
        this.modelClasses = modelClasses;
        this.spinnerDataList = spinnerDataList;

    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.ed_role.setText(modelClasses.get(position).getEditTextValue());
        holder.currentlyworking.setChecked(modelClasses.get(position).isCheckbox());


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_item, spinnerDataList);
        holder.spinner.setAdapter(adapter);

        holder.spinner.setSelection(modelClasses.get(position).getSelectedposition());
    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox currentlyworking;
        EditText ed_role;
        ImageView delete;
        Spinner spinner;


        public ViewHolder(View itemView) {
            super(itemView);
            currentlyworking = (CheckBox) itemView.findViewById(R.id.currentlyworking);
            ed_role = (EditText) itemView.findViewById(R.id.ed_role);
            delete = (ImageView) itemView.findViewById(R.id.delete);
            spinner = (Spinner) itemView.findViewById(R.id.spinner);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    modelClasses.remove(getAdapterPosition());

                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(), modelClasses.size());


                }
            });

            ed_role.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                    modelClasses.get(getAdapterPosition()).setEditTextValue((charSequence.toString()));
                }

                @Override
                public void afterTextChanged(Editable editable) {


                    if (ed_role.getText().toString().isEmpty()) {
                        modelClasses.get(getAdapterPosition()).setEditTextValue((editable.toString()));

                    }


                }
            });

            currentlyworking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    modelClasses.get(getAdapterPosition()).setCheckbox(b);

                }
            });

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    modelClasses.get(getAdapterPosition()).setSelectedposition(i);

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });



        }



    }
}
