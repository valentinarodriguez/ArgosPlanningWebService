/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.argos.WS.logica.utiles;

import com.suricata.argos.WS.entidades.Documento;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class DocumentosUtiles {
    private static final Logger LOGGER = Logger.getLogger(DocumentosUtiles.class);

    public static void guardarArchivo(Documento documento) throws IOException
    {
        String rutaCompleta = Constantes.NOMBRE_CARPETA_ARCHIVO_OPORTUNIDADES + documento.getNombre();
        File archivo = new File(rutaCompleta);
        File archivoCli = new File (documento.getRuta());
        FileUtils.copyFile(archivoCli, archivo);
        documento.setRuta(rutaCompleta);
    }

    /**
	 * Lee un archivo y lo transforma en un array de bytes
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("No se pudo completar la lectura de archivo "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}
