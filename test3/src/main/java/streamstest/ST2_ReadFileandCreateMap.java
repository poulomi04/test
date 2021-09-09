package streamstest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ST2_ReadFileandCreateMap {
public static void main(String[] args) {
		 writeFile();
		 System.out.println("Working Directory = " + System.getProperty("user.dir"));
		 readFile();
}

private static void readFile() {
	try(Stream<String> fileLine=Files.lines(Paths.get("E:"+File.separator+"EclipseWorkspace"+File.separator+"myfile3.txt"));){
		 Map<String, List<String>> myNewMap=
					fileLine.collect(Collectors.toMap((s)->s.split(":")[0], (s)->Arrays.asList(
							s.split(":")[1].split(","))));
			System.out.println("myNewMap:"+myNewMap);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
}

private static void writeFile() {
	Map<String, List<String>> myMap=new HashMap<String,List<String>>();
	List<String> redList=Arrays.asList("apple","strawberry","cherry");
	List<String> greenList=Arrays.asList("guava","grapes");
	List<String> yellowList=Arrays.asList("banana","sweet lime");
	
	myMap.put("Red", redList);
	myMap.put("Green", greenList);
	myMap.put("Yellow", yellowList);
	File myFile=new File("E:"+File.separator+"EclipseWorkspace"+File.separator+"myfile3.txt");
	try(BufferedWriter bw=new BufferedWriter(new FileWriter(myFile)))
	{
		 //myFile=new File("E:"+File.separator+"EclipseWorkspace"+File.separator+"myfile3.txt");
		 for(Map.Entry<String, List<String>> entry:myMap.entrySet()) {
			bw.write(entry.getKey()+":"+entry.getValue());
			bw.write(System.lineSeparator());
		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
}
}

