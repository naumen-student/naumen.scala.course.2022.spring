object Main extends App {
  def printing (args: String*) = {
    args foreach print
    println()
  }

  
  var firstString = "Scala! This is "
  var secondString = "efimov matvey"
  var thirdString = "yevtam vomife"
  var fourthString = "Hey bro "
  var fifthString = "i wanna see six hot string "
  printing("Hello ", firstString, secondString)
  printing(fourthString, firstString, secondString)
  printing(fifthString, firstString, secondString)
  printing(fourthString, firstString, thirdString)
  printing(fifthString, firstString, thirdString)
}