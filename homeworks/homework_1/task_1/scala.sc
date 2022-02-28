def Print(value: String): Unit ={
  println(value);
}

def GetReversedName(input: String): String={
  return input.split(' ').map(x=>x.reverse).mkString(" ")
}

def GetHelloStatement(welcomeStatement:String, name:String): String ={
  return welcomeStatement+" "+name
}

var welcomeStatement = "Hi"
var name = "Mikhail Barabanov"

Print(GetHelloStatement(welcomeStatement, name))