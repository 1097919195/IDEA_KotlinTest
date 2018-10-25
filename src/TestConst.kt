fun main(args: Array<String>) {
    println(constNameNormal)
    println(nameNormal)

    println(myObject.constNameObject)
    println(myObject.nameObject)

    println(MyClass.constNameCompanionObject)
    println(MyClass.nameCompanionObject)
}

const val testName = "ZhangSan"
//普通变量
const val constNameNormal: String = "constNameNormal$testName"
val nameNormal: String = "nameNormal$testName"

//object
object myObject {
    const val constNameObject: String = "constNameObject"
    val nameObject: String = "nameObject"
}

//companion object
class MyClass {
    companion object {
        const val constNameCompanionObject: String = "constNameCompanionObject"
        val nameCompanionObject: String = "nameCompanionObject"
    }
}
