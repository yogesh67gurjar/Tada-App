package com.example.tadaapp.Fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tadaapp.Adapters.AddCardsAdapter;
import com.example.tadaapp.R;
import com.example.tadaapp.databinding.FragmentAddNewAddressBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class AddNewAddressFragment extends BottomSheetDialogFragment {
    FragmentAddNewAddressBinding binding;

    static public boolean defaultCheck=false;
    static public String typeOfAddress="Home";

    public static final String EXTRA_FNAME="com.example.tadaseller.EXTRA_FNAME";
    public static final String EXTRA_LNAME="com.example.tadaseller.EXTRA_LNAME";
    public static final String EXTRA_APARTMENT="com.example.tadaseller.EXTRA_APARTMENT";
    public static final String EXTRA_CITY="com.example.tadaseller.EXTRA_CITY";
    public static final String EXTRA_STATE="com.example.tadaseller.EXTRA_STATE";
    public static final String EXTRA_COUNTRY="com.example.tadaseller.EXTRA_COUNTRY";
    public static final String EXTRA_ZIP="com.example.tadaseller.EXTRA_ZIP";
    public static final String EXTRA_PHONE="com.example.tadaseller.EXTRA_ZIP";
    public static final String EXTRA_DEFAULTSTATE="com.example.tadaseller.EXTRA_DEFAULTSTATE";
    public static final String EXTRA_TYPEOFADDRESS="com.example.tadaseller.EXTRA_TYPEOFADDRESS";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAddNewAddressBinding.inflate(inflater,container,false);

        // by default home type of address selected
        binding.homeBtn.setBackgroundResource(R.drawable.button_gradient_curve_corner_bg);
        binding.homeBtn.setTextColor(getResources().getColor(R.color.white));


        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewAddressFragment.this.dismiss();
                saveAddress();
            }
        });



        binding.homeBtn.setOnClickListener(v -> {
            typeOfAddress= (String) binding.homeBtn.getText();
            binding.homeBtn.setBackgroundResource(R.drawable.button_gradient_curve_corner_bg);
            binding.officeBtn.setBackgroundResource(R.drawable.button_white_curve_corner_bg);
            binding.otherBtn.setBackgroundResource(R.drawable.button_white_curve_corner_bg);
            binding.homeBtn.setTextColor(getResources().getColor(R.color.white));
            binding.officeBtn.setTextColor(getResources().getColor(R.color.black));
            binding.otherBtn.setTextColor(getResources().getColor(R.color.black));
        });
        binding.officeBtn.setOnClickListener(v -> {
            typeOfAddress= (String) binding.officeBtn.getText();
            binding.homeBtn.setBackgroundResource(R.drawable.button_white_curve_corner_bg);
            binding.officeBtn.setBackgroundResource(R.drawable.button_gradient_curve_corner_bg);
            binding.otherBtn.setBackgroundResource(R.drawable.button_white_curve_corner_bg);
            binding.homeBtn.setTextColor(getResources().getColor(R.color.black));
            binding.officeBtn.setTextColor(getResources().getColor(R.color.white));
            binding.otherBtn.setTextColor(getResources().getColor(R.color.black));
        });
        binding.otherBtn.setOnClickListener(v -> {
            typeOfAddress= (String) binding.otherBtn.getText();
            binding.homeBtn.setBackgroundResource(R.drawable.button_white_curve_corner_bg);
            binding.officeBtn.setBackgroundResource(R.drawable.button_white_curve_corner_bg);
            binding.otherBtn.setBackgroundResource(R.drawable.button_gradient_curve_corner_bg);
            binding.homeBtn.setTextColor(getResources().getColor(R.color.black));
            binding.officeBtn.setTextColor(getResources().getColor(R.color.black));
            binding.otherBtn.setTextColor(getResources().getColor(R.color.white));
        });

        binding.defaultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(defaultCheck)
                {
                    defaultCheck=false;
                }
                else
                {
                    defaultCheck=true;
                }
            }
        });

        binding.defaultText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(defaultCheck)
                {
                    defaultCheck=false;
                    binding.defaultBtn.setChecked(false);
                }
                else
                {
                    defaultCheck=true;
                    binding.defaultBtn.setChecked(true);
                }
            }
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewAddressFragment.this.dismiss();
                Toast.makeText(getActivity(), "Address Not Saved", Toast.LENGTH_SHORT).show();
            }
        });


        return binding.getRoot();
    }

    private void saveAddress() {

        String fname =binding.fnameEt.getText().toString();
        String lname=binding.lnameEt.getText().toString();
        String apartment =binding.apartmentEt.getText().toString();
        String city=binding.cityEt.getText().toString();
        String state =binding.stateEt.getText().toString();
        String country=binding.countryEt.getText().toString();
        String zip =binding.zipEt.getText().toString();
        String phone=binding.phoneEt.getText().toString();
        boolean defaultState=binding.defaultBtn.isChecked();

        if (binding.fnameEt.getText().toString().isEmpty()) {
            binding.fnameEt.setError ("Please Enter First Name");
            binding.fnameEt.requestFocus ();
        }
        else if (binding.lnameEt.getText().toString().isEmpty()) {
            binding.lnameEt.setError("Please Enter Last Name");
            binding.lnameEt.requestFocus();
        }
        else if (binding.apartmentEt.getText().toString().isEmpty()) {
            binding.apartmentEt.setError("Please Enter Apartment");
            binding.apartmentEt.requestFocus();
        }
        else if (binding.cityEt.getText().toString().isEmpty()) {
            binding.cityEt.setError("Please Enter City");
            binding.cityEt.requestFocus();
        }
        else if (binding.stateEt.getText().toString().isEmpty()) {
            binding.stateEt.setError("Please Enter State");
            binding.stateEt.requestFocus();
        }
        else if (binding.countryEt.getText().toString().isEmpty()) {
            binding.countryEt.setError("Please Enter Country");
            binding.countryEt.requestFocus();
        }
        else if (binding.zipEt.getText().toString().isEmpty()) {
            binding.zipEt.setError("Please Enter Zip Code");
            binding.zipEt.requestFocus();
        }
        else if (binding.phoneEt.getText().toString().isEmpty()) {
            binding.phoneEt.setError("Please Enter Contact Number");
            binding.phoneEt.requestFocus();
        }
        // type of address if bydefault home usko lene ki zrurat nhi alag se
        else {

            Intent data=new Intent();
            data.putExtra(EXTRA_FNAME,fname);
            data.putExtra(EXTRA_LNAME,lname);
            data.putExtra(EXTRA_APARTMENT,apartment);
            data.putExtra(EXTRA_CITY,city);
            data.putExtra(EXTRA_STATE,state);
            data.putExtra(EXTRA_COUNTRY,country);
            data.putExtra(EXTRA_ZIP,zip);
            data.putExtra(EXTRA_PHONE,phone);
            data.putExtra(EXTRA_DEFAULTSTATE,defaultState);
            data.putExtra(EXTRA_TYPEOFADDRESS,typeOfAddress);

//            setResult(RESULT_OK,data);
//            finish();
        }

    }

}