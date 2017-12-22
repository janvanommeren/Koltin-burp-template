package burp

import java.io.PrintWriter

class BurpExtender : IBurpExtender {

    val extensionName = "Kotlin Burp Template"

    override fun registerExtenderCallbacks(callbacks: IBurpExtenderCallbacks) {
        // set our extension name
        callbacks.setExtensionName(extensionName)

        // obtain our output and error streams
        val stdout = PrintWriter(callbacks.getStdout(), true)
        val stderr = PrintWriter(callbacks.getStderr(), true)

        // write a message to our output stream
        stdout.println("Hello output")

        // write a message to our error stream
        stderr.println("Hello errors")

        // write a message to the Burp alerts tab
        callbacks.issueAlert("Hello alerts")

        // throw an exception that will appear in our error stream
        throw RuntimeException("Hello exceptions")
    }

}