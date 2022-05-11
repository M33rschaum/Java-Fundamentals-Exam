package FinalExam;

import java.util.*;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> followers = new TreeMap<>();
        String command = scan.nextLine();

        while (!command.equals("Log out")){
            String splitCommand = command.split(":\\s+")[0];
            String follower = command.split(":\\s+")[1];

            switch (splitCommand){

                case "New follower":
                   if (!followers.containsKey(follower)){
                    followers.put(follower,new ArrayList<>());
                    followers.get(follower).add(0,0);
                    followers.get(follower).add(1,0);}
                    break;

                case "Like":
                    int likes = Integer.parseInt(command.split(":\\s+")[2]);
                    if (!followers.containsKey(follower)){
                        followers.put(follower,new ArrayList<>());
                        followers.get(follower).add(0,likes);
                        followers.get(follower).add(1,0);}
                    else{
                        int oldLikes = followers.get(follower).get(0);
                        followers.get(follower).set(0,oldLikes+likes);
                    }
                    break;

                case "Comment":
                    int newComments = 1;
                    if(!followers.containsKey(follower)){
                        followers.put(follower,new ArrayList<>());
                        followers.get(follower).add(0,0);
                        followers.get(follower).add(1,newComments);
                    }else{
                        int oldComments = followers.get(follower).get(1);
                        followers.get(follower).set(1,oldComments+newComments);
                    }
                    break;

                case "Blocked":
                    if (!followers.containsKey(follower)) {
                        System.out.println(String.format("%s doesn't exist.", follower));
                    } else {
                        followers.remove(follower, followers.get(follower));
                    }
                    break;
            }

            command= scan.nextLine();
        }

        System.out.printf("%d followers%n", followers.size());

        followers.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (getLikes(e1.getValue()) == getLikes(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    }

                    return Integer.compare(getLikes(e2.getValue()), getLikes(e1.getValue()));
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), sumLikesAndComments(e.getValue())));

    }


    public static int sumLikesAndComments(List<Integer> list) {
        return list.get(0) + list.get(1);
    }

    public static int getLikes(List<Integer> list){
        return list.get(0);
    }
}