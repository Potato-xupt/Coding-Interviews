package test;


import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import commons.ListNode;
import commons.RandomListNode;
import commons.TreeNode;
import question03.Duplicate;
import question07.ReConstructBinaryTree;
import question32.PrintByZ;
import question33.VerifySquenceOfBST;
import question34.FindPath;
import question35.Clone;
import question36.Convert;
import question39.MoreThanHalfNum_Solution;
import question40.GetLeastNumbers_SolutionByOn;
import question42.FindGreatestSumOfSubArray;
import question44.DigitAtIndex;
import question45.PrintMinNumber;
import question46.GetTranslationCount;
import question49.GetUglyNumber_SolutionByNormal;
import question51.InversePairs;
import question53.GetNumberOfKByFirstKAndFirstKadd1;
import question53.GetNumberOfKByFirstKAndLastK;
import question56.FindNumberAppearingOnce;
import question56.FindNumsAppearOnce;
import question58.LeftRotateString;
import question58.ReverseSentence;
import question59.MaxInWindows;
import question59.QueueWithMax;
import question60.DicesSum;
import question66.Multiply;
import question67.StrToInt;




@SuppressWarnings("unused")
public class Test {
	
	public boolean verify(ListNode head) {
		if(head == null) {
			return true;
		}
		ListNode node = head;
		ListNode newhead = null;
		ListNode pre = null;
		while(node != null) {
			ListNode next = node.next;
			if(next == null) {
				newhead = node;
			}
			node.next = pre;
			pre = node;
			node = next;
		}
		while((newhead != null || head != null) &&newhead == head) {
			newhead = newhead.next;
			head = head.next;
		}
		if(newhead == null && head == null) {
			return true;
		}
		return false;
	}
    
}
