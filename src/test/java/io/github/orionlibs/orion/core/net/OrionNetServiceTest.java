package io.github.orionlibs.orion.core.net;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.orionlibs.orion.core.net.OrionNetService;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class OrionNetServiceTest
{
    @Test
    public void test_buildIPAddress()
    {
        byte[] result = OrionNetService.buildIPAddressAsByteArray("192.168.70.127");
        assertThat(result).isEqualTo(new byte[]
        {-64, -88, 70, 127});
        String result1 = OrionNetService.buildIPAddressAsString(new byte[]
        {-64, -88, 70, 127}).get();
        assertThat(result1).isEqualTo("192.168.70.127");
    }
}