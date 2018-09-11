package br.unifil.dc.sisop;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Write a description of class ComandosInternos here.
 *
 * @author Ricardo Inacio Alvares e Silva
 * @version 180823
 */
public final class ComandosInternos {

    public static int exibirRelogio() {
        Date dateNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("'Sao' hh:mm 'de' dd.MM.yyyy");
        System.out.println(ft.format(dateNow));
        return 0;
    }
    
    public static int escreverListaArquivos(Optional<String> nomeDir) {
        File diretorio = new File(String.valueOf(nomeDir));

        List<File> resultList = new ArrayList<>();

        File[] fList = diretorio.listFiles();
        resultList.addAll(Arrays.asList(fList));

        for (File file : fList) {
            System.out.println(file.getAbsolutePath());
        }

        return 0;
    }
    
    public static int criarNovoDiretorio(String nomeDir) {
        new File(nomeDir).mkdir();
        return 0;
    }
    
    public static int apagarDiretorio(String nomeDir) {
        try {
            Files.delete(Paths.get(nomeDir));
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", nomeDir);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", nomeDir);
        } catch (IOException x) {
            System.err.println(x);
        }
        return 0;
    }
    
    public static int mudarDiretorioTrabalho(String nomeDir){
        System.setProperty("user.dir", nomeDir);
        return 0;
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
