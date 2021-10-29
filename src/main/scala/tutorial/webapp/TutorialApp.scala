package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.document
import scala.scalajs.js.annotation.JSExportTopLevel

object TutorialApp extends App {

  println("Hello Scala.js!")

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }
  appendPar(document.body, "Hello World")

  //You will notice the @JSExportTopLevel annotation. It tells the Scala.js compiler to make that method callable as top-level function from JavaScript.
  // 这种方式是笨重的：需要在html里定义button并调用这个导出的方法
  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage() = {
    appendPar(document.body, "You clicked the button!")
  }

  // 上面的可以换做下面这样
  val button = document.createElement("button")
  button.textContent = "New click me!"
  button.addEventListener("click", (e:dom.MouseEvent) => addClickedMessage())
  document.body.appendChild(button)


  // 再修改成放入一个方法中，加载时起作用
  def InitUI() = {
    val button = document.createElement("button")
    button.textContent = "Load a click me!"
    button.addEventListener("click", (e:dom.MouseEvent) => addClickedMessage())
    document.body.appendChild(button)
  }
  document.addEventListener("DOMContentLoaded", (e: dom.Event) => InitUI())


}
