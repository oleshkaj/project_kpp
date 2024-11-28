package com.example.pizzeria.models.cook;

import com.example.pizzeria.models.task.ICookTask;
import com.github.javafaker.Faker;
import lombok.Getter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Cook extends Thread
{
    private static AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final Integer cookId;
    private final String cookName;
    private CookStatus status;
    private final BlockingQueue<ICookTask> tasksQueue; // Черга задач, які кухар повинен виконати (якщо завдання немає, потік буде чекати, поки нове завдання не буде додано)

    public Cook()
    {
        this.cookId = ID_GENERATOR.getAndIncrement();
        Faker faker = new Faker();
        this.cookName = faker.name().firstName();
        this.status = CookStatus.FREE;
        this.tasksQueue = new LinkedBlockingQueue<>();
    }

    public Cook(String cookName)
    {
        this.cookId = ID_GENERATOR.getAndIncrement();
        this.cookName = cookName;
        this.status = CookStatus.FREE;
        this.tasksQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void run()
    {
        // Постійне виконання задач з черги, поки потік працює
        while (true)
        {
            try
            {
                // Блокування потоку до тих пір, поки не з'явиться задача в черзі
                ICookTask task = tasksQueue.take();
                // Виконання задачі
                task.execute(this);
            }
            catch (Exception e)
            {
                return;
            }
        }
    }

    public void addTask(ICookTask task)
    {
        tasksQueue.add(task);
    }

    public void pauseCook()
    {
        this.status = CookStatus.PAUSED;
    }

    public void resumeCook()
    {
        this.status = CookStatus.FREE;
    }

    public void setBusy()
    {
        if(this.status.equals(CookStatus.FREE))
        {
            this.status = CookStatus.BUSY;
        }
    }

    public void setFree()
    {
         if(this.status.equals(CookStatus.BUSY))
         {
             this.status = CookStatus.FREE;
         }
    }
}