package main.java.com.github.HufeisenGames.SkyAPI.particle.types;

import org.bukkit.Color;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPIPlugin;
import main.java.com.github.HufeisenGames.SkyAPI.particle.CreateParticle;

public class CircleParticle implements CreateParticle {
	private Location location;
	private float radius;
	private org.bukkit.Particle particle;
	private int count;
	private float space;
	private Color color;

	public CircleParticle(Location location, float radius, org.bukkit.Particle particle, int count, float space,
			Color color) {
		this.location = location;
		this.radius = radius;
		this.particle = particle;
		this.count = count;
		this.space = space;
		this.color = color;
	}

	public CircleParticle(Location location, float radius, org.bukkit.Particle particle, int count, float space) {
		this.location = location;
		this.radius = radius;
		this.particle = particle;
		this.count = count;
		this.space = space;
	}

	@Override
	public void spawn(Player player) {
		new BukkitRunnable() {

			@Override
			public void run() {

				for (double t = 0; t <= 2 * Math.PI * radius; t += space) {
					double x = (radius / 2 * Math.cos(t)) + location.getX() + 0.5;
					double y = (location.getY() + (radius / 2 * Math.sin(t) * 2));

					Location particleL = new Location(player.getWorld(), x, y, location.getZ() - 1);
					System.out.println(particleL);
					for(int r = 0; r <= radius; r-=0.1) {
						for (double n = 0; n <= 2 * Math.PI * r; n += space) {
							double x2 = (r / 2 * Math.cos(r)) + location.getX() + 0.5;
							double y2 = (location.getY() + (r / 2 * Math.sin(r) * 2));

							Location particleL2 = new Location(player.getWorld(), x2, y2, location.getZ() - 1);
							player.getWorld().spawnParticle(particle, particleL2, 1,
									new org.bukkit.Particle.DustOptions(Color.AQUA, 0.35f));
						}
					}
					
					if (color != null) {
						player.getWorld().spawnParticle(particle, particleL, count,
								new org.bukkit.Particle.DustOptions(color, 0.35f));
					} else {
						player.getWorld().spawnParticle(particle, particleL, count);
					}
					try {
						synchronized (this) {
							this.wait(1, 1);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}.runTaskTimerAsynchronously(SkyAPIPlugin.getPlugin(), 0, 10);
	}
}