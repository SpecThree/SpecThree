import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMiniMusicApp
{
	public static void main (String[] args)
	{
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	
	public void play()
	{
		try
		{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			ShortMessage smsg = new ShortMessage();
			smsg.setMessage(NOTE_ON, 1, 44, 100);
			MidiEvent note = new MidiEvent(smsg, 1);
			track.add(note);
			
			smsg = new ShortMessage();
			smsg.setMessage(NOTE_OFF, 1, 44, 100);
			note = new MidiEvent(smsg, 16);
			track.add(note);
			
			player.setSequence(seq);
			player.start();
			while (player.isRunning()) {}
			player.close();
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}
}