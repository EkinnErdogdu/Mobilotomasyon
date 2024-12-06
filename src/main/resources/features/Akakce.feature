Feature: Akakçe Mobil Uygulama Testi

  Scenario: Kullanıcı Akakçe mobil uygulamasında laptop araması yapar ve yüksek fiyatlı ürüne tıklar
    Given Kullanıcı Akakçe mobil uygulamasına girer
    And Üye olmadan devam et seçeneği ile ilerler
    When Arama kutusuna "Laptop" yazar ve aratır
    And Filtrele butonuna tıklar
    And Alt Kategori "Bilgisayar,Donanım" seçer ve Ürünleri Gör butonuna tıklar
    And Sıralama seçeneklerinden "En Yüksek Fiyat" seçeneğini seçer
    Then Sonuç ekranından 10. Ürüne tıklar ve Ürüne Git butonuna tıklar
    And Ürün detayı ekranında "Satıcıya Git" butonunun görüntülendiğini doğrular
