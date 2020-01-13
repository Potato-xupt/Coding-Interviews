package test;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import commons.ListNode;
import commons.RandomListNode;
import commons.TreeLinkNode;
import commons.TreeNode;
import question09.TwoQueueToStack;
import question10.JumpFloor;
import question10.JumpFloorII;
import question10.RectCover;
import question11.MinNumberInRotateArray;
import question12.HasPath;
import question13.MovingCount;
import question37.SerializeAndDeserialize;
import question38.CombineString;
import question38.Permutation;
import question40.GetLeastNumbers_SolutionByOn;


@SuppressWarnings("unused")
public class Main  {
	private static Semaphore A = new Semaphore(1);
	private static Semaphore B = new Semaphore(0);
	private static Semaphore C = new Semaphore(0);
	private static Semaphore D = new Semaphore(0);
	public static void main(String[] args) throws InterruptedException {
		GetLeastNumbers_SolutionByOn b = new GetLeastNumbers_SolutionByOn();
		int[] nums = {9, 14, 1, 16, 19, 13, 12};
		b.GetLeastNumbers_Solution(nums, 4);
		
	}
	
	

	
}
