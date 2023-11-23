import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniNoteCmdLine
{
	public static void main (String[] args)
	{
		MiniNoteCmdLine mini = new MiniNoteCmdLine();
		if (args.length < 2)
			System.out.println("Don't forget the instrument and note args");
		else
		{
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}
	}
	
	public void play(int _instrument, int _note)
	{
		try
		{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			ShortMessage smsg = new ShortMessage();
			smsg.setMessage(PROGRAM_CHANGE, 1, _instrument, 0);
			MidiEvent evt = new MidiEvent(smsg, 1);
			track.add(evt);
			
			smsg = new ShortMessage();
			smsg.setMessage(NOTE_ON, 1, _note, 100);
			evt = new MidiEvent(smsg, 1);
			track.add(evt);
			
			smsg = new ShortMessage();
			smsg.setMessage(NOTE_OFF, 1, _note, 100);
			evt = new MidiEvent(smsg, 40);
			track.add(evt);
			
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
} // 122 44