class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementCount = new HashMap<>();
        Map<Integer, Set<Integer>> elementsPerCount = new HashMap<>();

        for (int num : nums) {
            int count = elementCount.getOrDefault(num, 0);
            elementCount.put(num, count+1);
            Set<Integer> elementsWithCount = elementsPerCount.getOrDefault(count+1, new HashSet<>());
            elementsWithCount.add(num);
            elementsPerCount.put(count+1, elementsWithCount);
            if(count > 0) { 
                Set<Integer> oldElementsWithCount = elementsPerCount.getOrDefault(count, new HashSet<>());
                oldElementsWithCount.remove(num);
                if(oldElementsWithCount.size() == 0) {
                    elementsPerCount.remove(count);
                }
            }
        }
        if(elementCount.isEmpty()) {
            int[] r = new int[k];
            for (int i=0;i<k;i++) {
                r[i] = 0;
            }
            return r;
        }
        Set<Integer> counts = elementsPerCount.keySet();
        PriorityQueue<Integer> countQueue = new PriorityQueue<>();
        for(int c : counts) {
            countQueue.offer(c);
            if(countQueue.size()>k) {
                countQueue.poll();
            }
        }
        List<Integer> countQueueList = new ArrayList<>(countQueue);
        countQueueList.sort(Collections.reverseOrder());

        System.out.println("counts = " + counts);
        System.out.println("elementCount = " + elementCount);
        System.out.println("elementsPerCount = " + elementsPerCount);
        System.out.println("countQueue = " + countQueue);
        int[] result = new int[k];
        int resultLength = 0;
        int pos = 0;
        while(resultLength < k) {
            int c = countQueueList.get(pos++);
            System.out.println("c == " + c + " resultLength == " + resultLength);
            Set<Integer> elements= elementsPerCount.get(c);
            System.out.println("elements = " + elements);
            for (Integer element : elements) {
                result[resultLength++] = element;
                System.out.println("result Array = " + Arrays.toString(result) + " resultLength = " + resultLength);
                if(resultLength == k) {
                    break;
                }
            }
        }
        return result;
    }
}
