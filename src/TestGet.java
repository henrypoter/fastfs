import java.io.File;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;


public class TestGet {
public static void main(String[] args) throws Exception, Exception{
	  String classPath = new File(TestGet.class.getResource("/").getFile()).getCanonicalPath();  
      String configFilePath = classPath + File.separator + "fdfs_client.conf";  
      ClientGlobal.init(configFilePath);  
      TrackerClient trackerClient = new TrackerClient();  
      TrackerServer trackerServer = trackerClient.getConnection();  
      StorageServer storageServer = null;  
      StorageClient storageClient = new StorageClient(trackerServer, storageServer);  
        
      String group_name = "group2";  
      String remote_filename = "M00/00/00/wKhY2VbpXQeAC5ssAAAmUoj196g356.jpg";  
      FileInfo fi = storageClient.get_file_info(group_name, remote_filename);  
      String sourceIpAddr = fi.getSourceIpAddr();  
      long size = fi.getFileSize();  
      System.out.println("ip:" + sourceIpAddr + ",size:" + size);  
}
}
