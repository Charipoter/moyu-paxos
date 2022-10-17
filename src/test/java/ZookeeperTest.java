import org.apache.zookeeper.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ZookeeperTest {

    private String serverAddresses = "centos1:2181,centos1:2182,centos1:2183";

    @Test
    void test() throws IOException, InterruptedException, KeeperException {
        ZooKeeper client = new ZooKeeper(serverAddresses, 20000,
                event -> System.out.println("默认 watcher 被调用：" + event));

        client.addWatch("/", event -> {

            try {
                List<String> children = client.getChildren("/", true);
                children.forEach(System.out::println);

            } catch (KeeperException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }, AddWatchMode.PERSISTENT);

        Thread.sleep(Long.MAX_VALUE);
    }

}
