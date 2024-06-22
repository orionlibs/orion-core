package io.github.orionlibs.core.compression;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.compression.zip.ZIPCompressionService;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

public class CompressionService extends OrionService
{
    public static void compressToZIPAsStream(String tempFolder, Set<File> filesToCompress, OutputStream output, boolean deleteFilesAfterCompression) throws IOException
    {
        ZIPCompressionService.compressAsStream(tempFolder, filesToCompress, output, deleteFilesAfterCompression);
    }
}