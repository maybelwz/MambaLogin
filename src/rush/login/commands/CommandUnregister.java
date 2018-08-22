package rush.login.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rush.login.utils.DataManager;

public class CommandUnregister implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("unregister")) {

			if (args.length != 1) {
				s.sendMessage("�cComando incorreto, use /unregister <player>");
				return false;
			}

			File file = DataManager.getFile(args[0].toLowerCase(), "playerdata");

			if (!file.exists()) {
				s.sendMessage("�cO Player '" + args[0] + "' n�o pode ser encontrado no banco de dados.");
				return false;
			}

			file.delete();
			s.sendMessage("�aPlayer deleta do banco de dados com sucesso.");

			Player p = Bukkit.getPlayer(args[0]);
			if (p != null) {
				p.kickPlayer("�cVoc� foi desregistrado do banco de dados do servidor!\n�cPor favor relogue.");
			}
		}
		return false;
	}
}
