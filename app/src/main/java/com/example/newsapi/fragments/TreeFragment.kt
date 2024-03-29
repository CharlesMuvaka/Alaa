package com.example.newsapi.fragments

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.newsapi.R
import com.example.newsapi.databinding.FragmentMainBinding
import com.example.newsapi.databinding.FragmentTreeBinding
import com.example.newsapi.models.*
import com.example.newsapi.services.ApiClient
import com.example.newsapi.utils.Validator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TreeFragment : Fragment(), View.OnClickListener {
    private lateinit var  bind: FragmentTreeBinding
    private lateinit var apiClient:ApiClient
    private lateinit var progressDialog:ProgressDialog
    private lateinit var  mainBind: FragmentMainBinding
    val args: TreeFragmentArgs by navArgs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentTreeBinding.inflate(layoutInflater)
        mainBind = FragmentMainBinding.inflate(layoutInflater)
        mainBind.image3.setImageResource(R.drawable.ic_arrow)

        progressDialog = ProgressDialog(context)
        apiClient = ApiClient()
        apiClient.setIsDebug(false) // for logging purposes
        getAccessToken()

        val tree = args.tree
        setUpTreeData(tree)

        val parent = requireParentFragment().view

        if (parent != null){
//            bind.treeName.text = bind.root.id.toString()
            val image = parent.findViewById<ImageView>(R.id.image3)
        }

        bind.buy.setOnClickListener(this::onClick)

        return bind.root
    }

    private fun setUpTreeData(tree: Tree) {
        bind.treeName.text = tree.name
//        bind.image.setImageResource(tree.image!!)
        bind.species.text = tree.species

    }

    private fun getAccessToken() {
        apiClient.setGetAccessToken(true)
        apiClient.MpesaPayment().getAccessToken().enqueue(object : Callback<AccessToken>{
            override fun onResponse(call: Call<AccessToken>, response: Response<AccessToken>) {
                try{
                    if (response.isSuccessful){
                        apiClient.setAuthToken(response.body()!!.accessToken)
                    }else{
//                        bind.treeName.text = response.errorBody().toString()
                    }
                }catch (e: Exception){
//                    bind.treeName.text = e.message

                }
            }

            override fun onFailure(call: Call<AccessToken>, t: Throwable) {
//                bind.treeName.text = t.message
            }

        })
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TreeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onClick(p0: View?) {
        if (p0 == bind.buy){
            proceedToPayment()
        }
    }

    private fun proceedToPayment() {
        val phoneNumber = "0768761610"
        val amount = "200"

        performStkPush(phoneNumber, amount)
    }

    private fun performStkPush(phoneNumber: String, amount: String) {
        progressDialog.apply {
            setMessage("Processing your request")
            setTitle("Please wait..")
            isIndeterminate = true
            show()
        }
        val timeStamp = Validator().getTime()
        val stkPush = StkPush(
            BUSINESS_SHORT_CODE,
            Validator().getPassword(BUSINESS_SHORT_CODE, PASS_KEY, timeStamp),
            timeStamp,
            TRANSACTION_TYPE,
            amount,
            Validator().checkPhoneNumber(phoneNumber),
            PARTY_B,
            Validator().checkPhoneNumber(phoneNumber),
            CALL_BACK_URL,
            "i-plant Kenya",
            "Seedling Purchase"
        )
        apiClient.setGetAccessToken(false)

        apiClient.MpesaPayment().sendPushServiceRequest(stkPush).enqueue(object : Callback<StkPush> {
            override fun onResponse(call: Call<StkPush>, response: Response<StkPush>) {
                progressDialog.dismiss()
                try {
                    if (response.isSuccessful){
                        Toast.makeText(context, "Received successful", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(context, response.errorBody().toString(), Toast.LENGTH_LONG).show()

                    }
                }catch (e:Exception){
                    Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()

                }
            }

            override fun onFailure(call: Call<StkPush>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()

            }

        })

    }


}