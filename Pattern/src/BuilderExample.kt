class BuilderExample(builder : Builder){

    private var id : Int
    private var name : String?=null


    init {
        id=builder.id
        name=builder.name
    }

    class Builder{

        var id : Int = 0
        var name : String?=null

        fun setId(id : Int) : Builder{
            this.id=id
            return this
        }

        fun setString(name : String) : Builder{
            this.name=name
            return this
        }

        fun build() : BuilderExample{
            return BuilderExample(this)
        }
    }

    override fun toString(): String {
        return id.toString()+":"+name
    }
}

fun main(array: Array<String>){

    var example=BuilderExample.Builder().setId(20).setString("윤정현").build()
    println(example.toString())
}