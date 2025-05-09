import java.util.*;
import java.io.*;

class Solution {
    
    static class Job {
        public int id;
        public int reqTime;
        public int needTime;
        
        public Job(int id, int reqTime, int needTime) {
            this.id = id;
            this.reqTime = reqTime;
            this.needTime = needTime;
        }
    }
    
    static class Publisher {
        TreeMap<Integer, List<Job>> jobTimeMap;
        
        public Publisher(int[][] jobs) {
            jobTimeMap = new TreeMap<>();
            for(int i = 0; i < jobs.length; i++) {
                int id = i;
                int reqTime = jobs[i][0];
                int needTime = jobs[i][1];
                Job job = new Job(id, reqTime, needTime);
                if(jobTimeMap.containsKey(reqTime)) {
                    jobTimeMap.get(reqTime).add(job);
                    continue;
                }
                List<Job> newJobs = new ArrayList<>();
                newJobs.add(job);
                jobTimeMap.put(reqTime, newJobs);
            }  
        }
        
        public boolean canPublish() {
            return !jobTimeMap.isEmpty();
        }
        
        public List<Job> publish(int currentTime) {
            if(jobTimeMap.containsKey(currentTime)) {
                List<Job> jobs = jobTimeMap.remove(currentTime);
                return jobs;
            }
            return new ArrayList<>();
        }
    }
    
    static class Consumer {
        public int endOfCurrentJobTime;
        public int completeJobCount;
        public int returnTime;
        
        public Consumer() {
            this.endOfCurrentJobTime = 0;
            this.completeJobCount = 0;
            this.returnTime = 0;
        }
        
        public boolean canConsume(int currentTime) {
            return currentTime >= endOfCurrentJobTime;
        }
        
        public void consume(Job job, int currentTime) {
            returnTime += (currentTime + job.needTime) - job.reqTime;
            endOfCurrentJobTime = currentTime + job.needTime;
            completeJobCount++;
        }
        
        public int getReturnTimeAverage() {
            if(completeJobCount == 0) return 0;
            return (int)(returnTime / completeJobCount);
        }
    }
    
    PriorityQueue<Job> jobQ = new PriorityQueue<>((j1, j2) ->{
        if(j1.needTime == j2.needTime) {
            if(j1.reqTime == j2.reqTime) {
                return j1.id - j2.id;
            } else {
                return j1.reqTime - j2.reqTime;
            }
        } else {
            return j1.needTime - j2.needTime;
        }
    });
    
    public int solution(int[][] jobs) {
        Publisher publisher = new Publisher(jobs);
        Consumer consumer = new Consumer();
        int currentTime = 0;
        while(publisher.canPublish() || !jobQ.isEmpty()) {
            List<Job> publishedJobs = publisher.publish(currentTime);
            for(Job publishedJob : publishedJobs) {
                jobQ.add(publishedJob);
            }
            if(!jobQ.isEmpty() && consumer.canConsume(currentTime)) {
                Job job = jobQ.poll();
                consumer.consume(job, currentTime);
            }
            currentTime++;
        }
        return consumer.getReturnTimeAverage();
    }
}