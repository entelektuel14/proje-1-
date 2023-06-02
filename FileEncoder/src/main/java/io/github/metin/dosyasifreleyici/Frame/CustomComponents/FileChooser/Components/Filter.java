package io.github.metin.dosyasifreleyici.Frame.CustomComponents.FileChooser.Components;

import io.github.metin.dosyasifreleyici.Helper.FileHelper;
import java.io.File;
import javax.swing.filechooser.FileFilter;

// Java FileFilter.java sınıfının kalıtım yolu ile özelleştirilmiş hali.
// Bu sınıfın amacı, JFileChooser sınıfında seçili klasörün içerisindeki dosyaları filtreleyerek döndürmektir.
public class Filter extends FileFilter {

    // Seçili klasörün içerisindeki dosyaları filtrelemek için kullanılacak filtre.
    private FilterOption filterOption;

    // Kurucu metot.
    public Filter(FilterOption filterOption){
        this.filterOption = filterOption;
    }

    // Seçili klasörün içerisindeki dosyaları filtrelemek için kullanılacak filtreyi ayarlar.
    public void setFilterOption(FilterOption filterOption){
        this.filterOption = filterOption;
    }


    // Kalıtım yolu ile gelen accept(file:File):boolean metotunu özelleştirir.
    // Bu metot, dosya filtresinin seçili dosyayı kabul edip etmeyeceğini belirler.
    @Override
    public boolean accept(File file) {
        if (filterOption == FilterOption.ALL) return true;
        if (file.isDirectory()) return true;
        String extension = FileHelper.getExtension(file);
        for (String filterExtension : filterOption.getExtensions()) {
            if (filterExtension.equalsIgnoreCase(extension)) return true;
        }
        return false;
    }

    // Kalıtım yolu ile gelen getDescription():String metotunu özelleştirir.
    @Override
    public String getDescription() {
        return filterOption.getDescription();
    }
    
    
}
