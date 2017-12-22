package burp

import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import kotlin.test.assertEquals
import org.junit.Test as test

class TestExtender() {
    @test(expected = RuntimeException::class) fun t() {
        val callBacks = Mockito.mock(IBurpExtenderCallbacks::class.java)
        val extender = BurpExtender()
        extender.registerExtenderCallbacks(callBacks)

        verify(callBacks, times(1)).setExtensionName(extender.extensionName)
    }
}

