package com.suricata.argos.WS.sincronizar;

import org.springframework.scheduling.timer.ScheduledTimerTask;
import org.springframework.scheduling.timer.TimerFactoryBean;

public class TimerFactoryBeanAdapter extends TimerFactoryBean
{
	private static int cantidadInstancias = 0;
	
	private int numeroInstancia = 0;
	
	public TimerFactoryBeanAdapter()
	{
		cantidadInstancias = cantidadInstancias + 1;
		numeroInstancia = cantidadInstancias;
	}
	
	public void setScheduledTimerTasks(ScheduledTimerTask[] scheduledTimerTasks)
	{
		if (numeroInstancia != 1) // si hay mas de una instancia, no deberia ejecutar alguna tarea
		{
			return;
		}
		
		super.setScheduledTimerTasks(scheduledTimerTasks);
	}

}
