import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.sender.MessageSenderImpl;

public class TestData {

  public static Stream<Arguments> ips() {
    return Stream.of(
        Arguments.of(GeoServiceImpl.LOCALHOST, new Location(null, null, null, 0)),
        Arguments.of(GeoServiceImpl.MOSCOW_IP,
            new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
        Arguments.of(GeoServiceImpl.NEW_YORK_IP,
            new Location("New York", Country.USA, " 10th Avenue", 32)),
        Arguments.of("172.", new Location("Moscow", Country.RUSSIA, null, 0)),
        Arguments.of("96.", new Location("New York", Country.USA, null, 0)),
        Arguments.of("103.", null)
    );
  }

  public static Stream<Arguments> localization() {
    return Stream.of(
        Arguments.of("Welcome", Country.BRAZIL),
        Arguments.of("Welcome", Country.GERMANY),
        Arguments.of("Welcome", Country.USA),
        Arguments.of("Добро пожаловать", Country.RUSSIA)
    );
  }

  public static Stream<Arguments> sendData() {
    return Stream.of(
        Arguments.of(ImmutableMap.<String, String>builder()
            .put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11").build(), "Добро пожаловать"),
        Arguments.of(ImmutableMap.<String, String>builder()
            .put(MessageSenderImpl.IP_ADDRESS_HEADER, "76.44.183.149").build(), "Welcome"),
        Arguments.of(ImmutableMap.<String, String>builder()
            .put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149").build(), "Welcome"),
        Arguments.of(new HashMap<>(), "Welcome"),
        Arguments.of(
            ImmutableMap.<String, String>builder().put(MessageSenderImpl.IP_ADDRESS_HEADER, "")
                .build(), "Welcome")
    );
  }
}
