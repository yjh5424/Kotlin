import java.util.*

fun main(args: Array<String>) {


    val students = arrayOf(
            Studnet("윤정현",19),
            Studnet("유진선",22),
            Studnet("이슬",26),
            Studnet("이용재",27),
            Studnet("정성균",30))

    val changeStudent = students
            .filter { age -> age.age > 26 }
            .map { Teacher(it.name,it.age)  }
            .toList()

    val iterator = changeStudent.listIterator().iterator().let {
        it.forEach {
            println("The Teacher is ${it.name} , ${it.age}")
        }
    }



}




