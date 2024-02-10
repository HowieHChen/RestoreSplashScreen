@file:Suppress("FunctionName")

package com.gswxxn.restoresplashscreen.view

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import cn.fkj233.ui.activity.data.DataBinding
import cn.fkj233.ui.activity.data.Padding
import cn.fkj233.ui.activity.view.*
import com.highcapable.yukihookapi.hook.xposed.prefs.data.PrefsData

/**
 * 复制自 [cn.fkj233.ui.activity.data.InitView], 后续可能会使用更优办法实现, 而不是复制整个类
 */
class BlockMIUIItemData {
    companion object {
        val datalist = mutableMapOf<Int, ArrayList<BaseView>>()
    }
    val itemList: ArrayList<BaseView> = arrayListOf()
    private var bindingData = arrayListOf<DataBinding.BindingData>()

    fun GetDataBinding(defValue: () -> Any, recvCallbacks: (View, Int, Any) -> Unit): DataBinding.BindingData {
        return DataBinding.get(bindingData, defValue, recvCallbacks)
    }

    fun Author(authorHead: Drawable, authorName: String, authorTips: String? = null, round: Float = 30f, onClickListener: (() -> Unit)? = null, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(ImageTextV(authorHead, authorName, authorTips, round, onClickListener, dataBindingRecv))
    }

    fun Page(pageHead: Drawable, textSummaryV: TextSummaryV, round: Float = 0f, onClickListener: (() -> Unit)? = null, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(PageV(pageHead, textSummaryV, round, onClickListener, dataBindingRecv))
    }

    fun Line() {
        itemList.add(LineV())
    }

    fun SeekBar(key: String, min: Int, max: Int, defaultProgress: Int, dataSend: DataBinding.Binding.Send? = null, dataBindingRecv: DataBinding.Binding.Recv? = null, callBacks: ((Int, TextView) -> Unit)? = null) {
        itemList.add(SeekBarV(key, min, max, defaultProgress, dataSend, dataBindingRecv, callBacks))
    }

    fun TextSummaryWithSpinner(textV: TextSummaryV, spinnerV: SpinnerV, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(TextSummaryWithSpinnerV(textV, spinnerV, dataBindingRecv))
    }

    fun Text(text: String? = null, textId: Int? = null, textSize: Float? = null, colorInt: Int? = null, colorId: Int? = null, padding: Padding? = null, dataBindingRecv: DataBinding.Binding.Recv? = null, typeface: Typeface? = null, onClickListener: (() -> Unit)? = null) {
        itemList.add(TextV(text, textId, textSize, colorInt, colorId, padding, dataBindingRecv, typeface, onClickListener))
    }

    fun SeekBarWithText(key: String = "", min: Int, max: Int, defaultProgress: Int = 0, dataBindingRecv: DataBinding.Binding.Recv? = null, dataBindingSend: DataBinding.Binding.Send? = null, callBacks: ((Int, TextView) -> Unit)? = null) {
        itemList.add(SeekBarWithTextV(key, min, max, defaultProgress, dataBindingRecv, dataBindingSend, callBacks))
    }

    fun TextSummaryArrow(textSummaryV: TextSummaryV, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(TextSummaryWithArrowV(textSummaryV, dataBindingRecv))
    }

    fun TextA(text: String? = null, textId: Int? = null, onClickListener: (() -> Unit)? = null, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(TextSummaryWithArrowV(TextSummaryV(text, textId, onClickListener = onClickListener), dataBindingRecv))
    }

    fun TextSummaryWithSwitch(textSummaryV: TextSummaryV, switchView: SwitchView, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(TextSummaryWithSwitchView(textSummaryV, switchView, dataBindingRecv))
    }

    fun TitleText(text: String? = null, textId: Int? = null,colorInt: Int? = null, colorId: Int? = null, dataBindingRecv: DataBinding.Binding.Recv? = null, onClickListener: (() -> Unit)? = null) {
        itemList.add(TitleTextV(text, textId,colorInt, colorId,dataBindingRecv, onClickListener))
    }

    fun TextWithSwitch(textV: TextV, switchV: SwitchV, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(TextWithSwitchV(textV, switchV, dataBindingRecv))
    }

    fun TextS(text: String? = null, textId: Int? = null, key: String, defValue: Boolean=false, onClickListener: ((Boolean) -> Unit)? = null, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(TextWithSwitchV(TextV(text, textId), SwitchV(key, defValue, onClickListener = onClickListener), dataBindingRecv))
    }

    fun TextWithSpinner(textV: TextV, spinnerV: SpinnerV, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(TextWithSpinnerV(textV, spinnerV, dataBindingRecv))
    }

    fun CustomView(view: View, dataBindingRecv: DataBinding.Binding.Recv? = null) {
        itemList.add(CustomViewV(view, dataBindingRecv))
    }

    fun RadioView(key: String, dataBindingRecv: DataBinding.Binding.Recv? = null, data: RadioViewV.RadioData.() -> Unit) {
        itemList.add(RadioViewV(key, dataBindingRecv, data))
    }

    fun TextSummary(text: String? = null, textId: Int? = null, tips: String? = null, colorInt: Int? = null, colorId: Int? = null, tipsId: Int? = null, dataBindingRecv: DataBinding.Binding.Recv? = null, onClickListener: (() -> Unit)? = null) {
        itemList.add(TextSummaryV(text, textId, tips, colorInt, colorId, tipsId, dataBindingRecv, onClickListener))
    }

    fun SeekBarWithStatus(
        titleID: Int,
        pref: PrefsData<Int>? = null,
        min: Int,
        max: Int,
        defaultProgress: Int = 0,
        isPercentage: Boolean = false,
        progressColor: Int = 0xFF0d7AEC.toInt(),
        drawHuePanel: Boolean = false,
        dataBindingRecv: DataBinding.Binding.Recv? = null,
        dataBindingSend: DataBinding.Binding.Send? = null,
        onProgressChanged: ((value: Int) -> Unit)? = null
    ) {
        itemList.add(SeekBarWithTitleView(titleID, pref, min, max, defaultProgress, isPercentage, progressColor, drawHuePanel, dataBindingRecv, dataBindingSend, onProgressChanged))
    }
}