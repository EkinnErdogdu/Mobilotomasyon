package stepDefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import io.cucumber.java.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.cucumber.java.en.*;
import java.net.URL;
import java.net.MalformedURLException;

public class AkakceSteps {

    private AndroidDriver<MobileElement> driver;


    @Given("Kullanıcı Akakçe mobil uygulamasına girer")
    public void kullanici_akakce_mobil_uygulamasina_girer() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.akakce.android");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.akakce.android.activity.MainActivity");


        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }


    @And("Üye olmadan devam et seçeneği ile ilerler")
    public void uye_olmadan_devam_et_seceneği_ile_ilerler() {
        MobileElement withoutLoginButton = driver.findElement(By.id("com.akakce.android:id/continueWithoutLogin"));
        withoutLoginButton.click();
    }


    @When("Arama kutusuna {string} yazar ve aratır")
    public void arama_kutusuna_yazar_ve_aratir(String searchTerm) {
        MobileElement searchBox = driver.findElement(By.id("com.akakce.android:id/search_box"));
        searchBox.sendKeys(searchTerm);
        MobileElement searchButton = driver.findElement(By.id("com.akakce.android:id/search_button"));
        searchButton.click();
    }


    @And("Filtrele butonuna tıklar")
    public void filtrele_butonuna_tiklar() {
        MobileElement filterButton = driver.findElement(By.id("com.akakce.android:id/filter_button"));
        filterButton.click();
    }


    @And("Alt Kategori {string} seçer ve Ürünleri Gör butonuna tıklar")
    public void alt_kategori_secer_ve_urunleri_gor_butonuna_tiklar(String category) {
        MobileElement categoryDropdown = driver.findElement(By.id("com.akakce.android:id/category_dropdown"));
        categoryDropdown.click();

        MobileElement categoryOption = driver.findElement(By.xpath("//android.widget.TextView[@text='" + category + "']"));
        categoryOption.click();

        MobileElement viewProductsButton = driver.findElement(By.id("com.akakce.android:id/view_products_button"));
        viewProductsButton.click();
    }

    @And("Sıralama seçeneklerinden {string} seçeneğini seçer")
    public void siralama_seceneklerinden_secenegini_secer(String sortOption) {
        MobileElement sortDropdown = driver.findElement(By.id("com.akakce.android:id/sort_dropdown"));
        sortDropdown.click();

        MobileElement sortOptionElement = driver.findElement(By.xpath("//android.widget.TextView[@text='" + sortOption + "']"));
        sortOptionElement.click();
    }

    @Then("Sonuç ekranından 10. Ürüne tıklar ve Ürüne Git butonuna tıklar")
    public void sonuc_ekranindan_10_urune_tiklar_ve_urunegit_butonuna_tiklar() {
        MobileElement product = driver.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[10]"));
        product.click();

        MobileElement productButton = driver.findElement(By.id("com.akakce.android:id/go_to_product_button"));
        productButton.click();
    }


    @And("Ürün detayı ekranında {string} butonunun görüntülendiğini doğrular")
    public void urun_detayi_ekraninda_butonunun_goruntulendigini_dogrular(String buttonName) {

        MobileElement sellerButton = driver.findElement(By.xpath("//go_to_seller_button.widget.TextView[@text='" + buttonName + "']"));
        sellerButton.click();

        Assertions.assertTrue(sellerButton.isDisplayed(),"Satıcıya Git butonu görünmüyor!");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
