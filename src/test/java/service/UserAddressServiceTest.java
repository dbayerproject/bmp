package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.damrin.bmp.domain.UserAddress;
import ru.damrin.bmp.repository.UserAddressRepository;
import ru.damrin.bmp.service.UserAddressServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAddressServiceTest {

    @Mock
    UserAddressRepository userAddressRepository;

    @InjectMocks
    UserAddressServiceImpl userAddressService;

    @Test
    void findAddressLine1Test() {
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressLine1("address_line_1");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("address_line_1", result.getAddressLine1());

    }

    @Test
    void updateAddressLine1Test() {
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressLine1("address_line_1");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("address_line_1", result.getAddressLine1());
        userAddress.setAddressLine1("another_address_line_1");
        assertEquals("another_address_line_1", result.getAddressLine1());
    }

    @Test
    void findAddressLine2Test() {
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressLine2("address_line_2");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("address_line_2", result.getAddressLine2());
    }

    @Test
    void updateAddressLine2Test() {
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressLine2("address_line_2");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("address_line_2", result.getAddressLine2());
        userAddress.setAddressLine1("another_address_line_2");
        assertEquals("another_address_line_2", result.getAddressLine1());
    }

    @Test
    void findCityTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setCity("City");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("City", result.getCity());
    }

    @Test
    void updateCityTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setCity("City");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("City", result.getCity());
        userAddress.setCity("another_City");
        assertEquals("another_City", result.getCity());
    }

    @Test
    void findPostalCodeTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setPostalCode(123456);
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals(123456, result.getPostalCode());
    }

    @Test
    void updatePostalCodeTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setPostalCode(123456);
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals(123456, result.getPostalCode());
        userAddress.setPostalCode(654321);
        assertEquals(654321, result.getPostalCode());
    }

    @Test
    void findCountryTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setCountry("Country");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("Country", result.getCountry());
    }

    @Test
    void updateCountryTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setCountry("Country");
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals("Country", result.getCountry());
        userAddress.setCountry("another_country");
        assertEquals("another_country", result.getCountry());
    }

    @Test
    void findTelephoneTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setTelephone(123456);
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals(123456, result.getTelephone());
    }

    @Test
    void updateTelephoneTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setTelephone(123456);
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals(123456, result.getTelephone());
        userAddress.setTelephone(654321);
        assertEquals(654321, result.getTelephone());
    }

    @Test
    void deleteTelephoneTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setEmptyTelephone();
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertSame("", result.getEmptyTelephone());
    }

    @Test
    void findMobileTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setMobile(123456);
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals(123456, result.getMobile());
    }

    @Test
    void updateMobileTest() {
        UserAddress userAddress = new UserAddress();
        userAddress.setMobile(123456);
        userAddress.setId(1);
        Optional<UserAddress> userAddressOptional = Optional.of(userAddress);
        when(this.userAddressRepository.findById(anyInt())).thenReturn(userAddressOptional);
        UserAddress result = this.userAddressService.findById(1);
        assertEquals(123456, result.getMobile());
        userAddress.setMobile(654321);
        assertEquals(654321, result.getMobile());
    }
}
