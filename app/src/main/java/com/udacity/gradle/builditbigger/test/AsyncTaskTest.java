package com.udacity.gradle.builditbigger.test;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by akshitgupta on 14/08/16.
 */
public class AsyncTaskTest extends AndroidTestCase {

    @Test
    public void verifyAsyncTaskResponse() {

        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                assertFalse("Async Task is producing empty string", result.length() == 0);

            }
        });

        task.execute(new Pair<Context, String>(getContext(), "Manfred"));
    }
}
