package com.suricata.argos.WS.sincronizar;

import com.suricata.argos.argos.WS.logica.utiles.Constantes;


public class ScheduledTimerTaskAdapter extends org.springframework.scheduling.timer.ScheduledTimerTask
{
	
	public long getPeriod()
	{
		// recuperar el periodo del periodo recuperado del servicio de configuracion
		Long periodFromKey = getPeriodFromKey();
		
		if (periodFromKey == null)
		{
			return super.getPeriod();
		} else
		{
			return periodFromKey.longValue();
		}
	}

	private Long getPeriodFromKey()
	{
		Long retVal = null;
		
		// recuperamos en periodo en minutos.
		String periodString = Constantes.TIEMPO_INTERVALO_SINCRONIZACION;
		
		try
		{
			retVal = Long.parseLong(periodString);
		}
		catch (NumberFormatException e)
		{
		}
		
		if (retVal != null)
		{
			// lo pasamos a milisegundos.
			retVal = retVal * 60L * 1000L;
		}
		
		return retVal;
	}

	
	public boolean isOneTimeTask()
	{
		return false;
	}
	


}
