package io.github.metin.dosyasifreleyici.Frame.CustomComponents.FileChooser;

import io.github.metin.dosyasifreleyici.Frame.CustomComponents.FileChooser.Components.Filter;
import io.github.metin.dosyasifreleyici.Frame.CustomComponents.FileChooser.Components.FilterOption;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

// Java JFileChooser.java sınıfının kalıtım yolu ile özelleştirilmiş hali.
// Bu sınıfın amacı, JFileChooser sınıfında seçili klasörün içerisindeki dosyaları filtreleyerek döndürmektir.
public class FilteredFileChooser extends JFileChooser {

    // Açılır pencerede görüntülenecek dosya türü filtresi.
    private Filter fileChooserFilter;

    // Seçili klasörün içerisindeki dosyaları filtrelemek için kullanılacak filtre.
    private Filter baseFilter;

    // Kurucu metot.
    public FilteredFileChooser() {
        setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        setFileHidingEnabled(false);
        for (FileFilter filter : getChoosableFileFilters()) {
            removeChoosableFileFilter(filter);
        }
        fileChooserFilter = new Filter(FilterOption.ALL);
        baseFilter = new Filter(FilterOption.ALL);
        addChoosableFileFilter(fileChooserFilter);
    }

    // Seçili klasörün içerisindeki dosyaları filtrelemek için kullanılacak filtreyi ayarlar.
    public void setFilterOption(FilterOption option) {
        baseFilter.setFilterOption(option);
    }

    // Seçili klasörün içerisindeki dosyaları filtrelemek için kullanılacak filtreyi döndürür.
    public File[] getSelectedFoldersFilteredFiles() {
        return getSelectedFoldersFilteredFiles(getSelectedFile());
    }

    // Girilen klösörün içerisindeki dosyaları filtrelemek için kullanılacak filtreyi döndürür.
    public File[] getSelectedFoldersFilteredFiles(File file) {
        File[] allFiles = file.listFiles();
        File[] resultFiles = new File[allFiles.length];
        int i = 0;
        for (File arrayFile : allFiles){
            if (baseFilter.accept(arrayFile)) {
                resultFiles[i] = arrayFile;
                i++;
            }
        }
        return Arrays.copyOf(resultFiles, i);
    }
    
}
