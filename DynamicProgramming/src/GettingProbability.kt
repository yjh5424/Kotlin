import java.util.*


fun main(args: Array<String>) {

    println("전체경기를 입력하세요")
    val totalMatch = GettingProbability.Static.scanner.nextDouble()
    println("이긴경기를 입력하세요")
    val winningMatch = GettingProbability.Static.scanner.nextDouble()


    println(GettingProbability.Static.winningRate(totalMatch,winningMatch))
    GettingProbability.Static.winningRatePlusMatch(totalMatch,winningMatch)

}

class GettingProbability{

    object Static{
        val scanner=Scanner(System.`in`)
        val TEN_BILLION=1000000000

        fun winningRate(totalMatch : Double,winingMatch: Double) : String {
            return "승률"+((winingMatch/totalMatch)*100.0).toString()+"%"
        }

        fun winningRatePlusMatch(totalMatch : Double,winingMatch: Double){

            var plusMatchRate  =(winingMatch+TEN_BILLION/totalMatch+TEN_BILLION)*100
            var matchRate=(winingMatch/totalMatch)*100.0

            println(plusMatchRate)
            println(matchRate)

        }

    }
}