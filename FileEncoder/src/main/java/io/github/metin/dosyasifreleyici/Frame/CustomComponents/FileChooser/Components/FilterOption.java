package io.github.metin.dosyasifreleyici.Frame.CustomComponents.FileChooser.Components;

// Bu enum sınıfı, FilteredFileChooser sınıfında kullanılan filtreleme seçeneklerini içerir.
// Format ve açılır paneldeki format açıklamasını statik olarak içerir.
// Bu yapı sayesinde yeni format istendiğinde sadece bu enum sınıfına eklenmesi yeterlidir.
public enum FilterOption {
    ONLY_TXT("\"txt\"", new String[]{"txt"}),
    ONLY_PDF("\"pdf\"", new String[]{"pdf"}),
    ONLY_PNG("\"png\"", new String[]{"png"}),
    ALL("\"Her dosya geçerli\"", new String[]{"*"}),
    ;

    // Bu filitrelemenin açıklaması.
    private String description;

    // Bu filitrelemenin desteklediği dosya uzantıları.
    private String[] extensions;
    
    FilterOption(String description, String[] extensions) {
        this.description = description;
        this.extensions = extensions;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String[] getExtensions() {
        return extensions;
    }
}
