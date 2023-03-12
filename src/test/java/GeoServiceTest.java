import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {

  GeoService geoService;

  @BeforeEach
  public void beforeEach() {
    geoService = new GeoServiceImpl();
  }

  @ParameterizedTest
  @MethodSource("TestData#ips")
  public void getLocationByIpTest(String ip, Location expectedLocation) {
    Location location = geoService.byIp(ip);
    Assertions.assertEquals(expectedLocation, location);
  }

  @Test
  public void getLocationByCoordinatesTest() {
    Class<RuntimeException> expected = RuntimeException.class;

    Executable executable = () -> geoService.byCoordinates(103.6, 34.8);

    Assertions.assertThrows(expected, executable);
  }
}
