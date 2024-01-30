package com.Test_Technical.StepDef;

import com.Test_Technical.BaseTest;
import com.Test_Technical.Web.Login_Test;
import com.Test_Technical.Web.Search_Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Website extends BaseTest {

    Login_Test loginTest;
    Search_Test searchTest;

    @Given("User berada pada halaman awal")
    public void userBeradaPadaHalamanAwal() {
        loginTest = new Login_Test(driver);
        loginTest.driverHome();
        loginTest.JudulWebsite();
    }

    //Login Testing
    @And("User click icon berbentuk seperti orang didalam bingkai")
    public void userClickIconBerbentukSepertiOrangDidalamBingkai() {
        loginTest.ClickLogin();
    }

    @When("User masuk didalam halaman login")
    public void userMasukDidalamHalamanLogin() {
    }

    @And("User memasukan email {string}")
    public void userMemasukanEmail(String email) {
        loginTest.EmailAkun(email);
    }

    @And("User memasukan password {string}")
    public void userMemasukanPassword(String pass) {
        loginTest.PasswordAkun(pass);
    }

    @When("User click button login")
    public void userClickButtonLogin() {
        loginTest.clickButtonLogin();
    }

    @And("User melihat tulisan {string}")
    public void userMelihatTulisan(String text) throws InterruptedException {
        loginTest.LoginAkun(text);
        Thread.sleep(3000);
    }

    @Then("User kembali ke halaman utama dan berhasil login")
    public void userKembaliKeHalamanUtama() {
    }

    //Search testing
    @And("User click search bar pada bagian atas")
    public void userClickSearchBarPadaBagianAtas() {
        searchTest = new Search_Test(driver);
    }

    @When("User mencari berita tentang {string} dan {string}")
    public void userMencariBeritaTentang(String berita, String search) throws InterruptedException {
        searchTest.searchBerita(berita, search);
        Thread.sleep(4000);
    }

    @Then("Website menampilkan hasil pencarian {string}")
    public void websiteMenampilkanHasilPencarian(String pencarian) {
        searchTest.tulisanTampil(pencarian);
    }

    @Then("Tulisan sudah terhapus")
    public void tulisanSudahTerhapus() {
        searchTest.TulisanTerhapus();
    }
}
