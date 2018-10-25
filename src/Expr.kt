//定义一个公共的接口
interface Expr

//实现接口
class Num(val value: Int) : Expr        // 1 带有一个属性、值而且实现了Expr接口的简单的值对象类
class Sum(val left: Expr, val right: Expr) : Expr    // 2 求和操作的参数可以是任意的Expr：Num对象或者其他的Sum对象


fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num        // 1 显式的Num类型转换是多余的
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)    // 2 变量e是智能类型转换
    }
    throw IllegalArgumentException("Unknown expression")
}