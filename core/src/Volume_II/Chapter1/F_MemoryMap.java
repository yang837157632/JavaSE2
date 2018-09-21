package Volume_II.Chapter1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * Created by Star Yang on 2017/4/19.
 */
public class F_MemoryMap {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Path filename = Paths.get("employee.dat");
        String[] methodNames = {"checksumInputStream","checksumBufferedInputStream" ,"checksumRandomAccessFile","checksumMappedFile"};
        for(int i=0;i<methodNames.length;i++){
            long start = System.currentTimeMillis();
            Method method = F_MemoryMap.class.getMethod(methodNames[i], Path.class);
            long crcValue = (Long)method.invoke(null, filename);
            long end = System.currentTimeMillis();
            System.out.print(Long.toHexString(crcValue) + "\t");
            System.out.println((end - start) + " milliseconds");

        }

    }

    public static long checksumInputStream(Path filename) throws IOException {
        InputStream in = Files.newInputStream(filename);
        CRC32 crc = new CRC32();
        int c;
        while ((c = in.read()) != -1)
            crc.update(c);
        in.close();
        return crc.getValue();
    }

    public static long checksumBufferedInputStream(Path filename) throws IOException {
        InputStream in = new BufferedInputStream(Files.newInputStream(filename));
        CRC32 crc = new CRC32();
        int c;
        while ((c = in.read()) != -1)
            crc.update(c);
        in.close();
        return crc.getValue();
    }

    public static long checksumRandomAccessFile(Path filename) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filename.toFile(), "r");
        long length = file.length();
        CRC32 crc = new CRC32();
        for (long p = 0; p < length; p++) {
            file.seek(p);
            crc.update(file.readByte());
        }
        file.close();
        return crc.getValue();
    }

    public static long checksumMappedFile(Path filename) throws IOException {
        FileChannel channel = FileChannel.open(filename);
        CRC32 crc = new CRC32();
        int length = (int) channel.size();
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
        for (int p = 0; p < length; p++)
            crc.update(buffer.get(p));
        return crc.getValue();
    }
}
