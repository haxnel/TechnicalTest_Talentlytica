Feature: Testing Login pada Website Kompas

  @LoginTest_Positive
  Scenario: User dapat melakukan Login
    Given User berada pada halaman awal
    And User click icon berbentuk seperti orang didalam bingkai
    When User masuk didalam halaman login
    And User memasukan email "Email Terdaftar"
    And User memasukan password "Password Email Terdaftar"
    When User click button login
    And User melihat tulisan "Selamat Datang"
    Then User kembali ke halaman utama dan berhasil login

  @LoginTest_Negative
  Scenario: User tidak dapat melakukan login
    Given User berada pada halaman awal
    And User click icon berbentuk seperti orang didalam bingkai
    When User masuk didalam halaman login
    And User memasukan email "Akun tidak terdaftar"
    And User memasukan password "Password Bebas"
    When User click button login
    Then User melihat tulisan "KG Media ID atau password yang kamu masukkan salah"