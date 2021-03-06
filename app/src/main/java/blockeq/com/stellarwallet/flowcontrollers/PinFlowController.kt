package blockeq.com.stellarwallet.flowcontrollers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import blockeq.com.stellarwallet.R
import blockeq.com.stellarwallet.activities.PinActivity
import blockeq.com.stellarwallet.models.PinViewState

object PinFlowController {

    private val TAG = PinFlowController::class.java.simpleName

    const val OBJECT = "object"

    fun launchPinActivity(context: Context, pinViewState: PinViewState, isLoginLaunch : Boolean) {
        val intent = Intent(context, PinActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(OBJECT, pinViewState)
        intent.putExtras(bundle)
        if (isLoginLaunch) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        (context as Activity).startActivityForResult(intent, PinActivity.PIN_REQUEST_CODE)
        context.overridePendingTransition(R.anim.slide_in_up, R.anim.stay)
    }
}
