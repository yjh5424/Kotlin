import kotlin.properties.Delegates


class ObserverExample{

    interface ValueChangeObserver {
        fun onValueChanged(value : String)
        fun onStringUpper(str : String)
    }

    class ValueChangeObserverImpl : ValueChangeObserver{
        override fun onStringUpper(str: String){
            println(str.toUpperCase())
        }

        override fun onValueChanged(value: String) {
            println("changeValue is $value")
        }

    }

    class ObservableChangeText(observer: ValueChangeObserver){
        var text : String by Delegates.observable(
                initialValue = "default",
                onChange = {
                    property, oldValue, newValue ->
                    observer.onValueChanged(newValue)
                })
    }

    //추가적으로 어떤 객체를 변경하는 클래스를 만들면 모든 종속된 객체에 자동으로 통지해주고 업데이트를 해준다,
    class ObservableChangeStringUpper(observer: ValueChangeObserver){
        var text : String by Delegates.observable(
                initialValue = "default",
                onChange = {
                    property, oldValue, newValue ->
                    observer.onStringUpper(newValue)
                })
    }

}


fun main(array: Array<String>){
    val observableChangeText = ObserverExample.ObservableChangeText(ObserverExample.ValueChangeObserverImpl())
    val observableChangeStringUpper = ObserverExample.ObservableChangeStringUpper(ObserverExample.ValueChangeObserverImpl())

    observableChangeText.text="안녕하세요 첫번째입니다."
    observableChangeText.text="안녕하세요 두번째입니다."

    observableChangeStringUpper.text="this is a cat"
}