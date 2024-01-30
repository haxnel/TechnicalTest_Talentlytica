Feature: Testing Search Bar pada website Kompas

  @SearchTest_Positive
  Scenario: User dapat mencari berita pada bagian Search Bar
    Given User berada pada halaman awal
    And User click search bar pada bagian atas
    When User mencari berita tentang "Kebakaran" dan "Enter"
    Then Website menampilkan hasil pencarian "PENCARIAN \"KEBAKARAN\""

  @SearchTest_Negative
  Scenario: Pada bagian search bar hanya terdapat tanda X
    Given User berada pada halaman awal
    And User click search bar pada bagian atas
    When User mencari berita tentang "Kebakaran" dan "click search"
    Then Tulisan sudah terhapus